package com.jat;

import com.jat.config.Slf4jLogFactory;
import com.jat.model.Test1Jat;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.template.Engine;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.wxaapp.WxaConfig;
import com.jfinal.wxaapp.WxaConfigKit;

public class DbConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants constants) {
        //加载系统属性配置文件 随后可用getProperty(...)获取值
        loadPropertyFile("db.txt");

        // ApiConfigKit 设为开发模式可以在开发阶段输出请求交互的 xml 与 json 数据
        ApiConfigKit.setDevMode(constants.getDevMode());

        //绑定slf4j+log4j2
        constants.setLogFactory(new Slf4jLogFactory());
    }

    @Override
    public void configRoute(Routes routes) {
        routes.scan("com.jat.controller");
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        String jdbcUrlString=getProperty("jdbcUrl");
        String userName=getProperty("user");
        String password=getProperty("password");
        DruidPlugin druidPlugin = new DruidPlugin(jdbcUrlString,userName,password);
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);

        activeRecordPlugin.setDevMode(true);
        activeRecordPlugin.setShowSql(true);

        activeRecordPlugin.addMapping("test1_jat", Test1Jat.class);//完成映射

        String cacheName="ktvdata";
        String host=getProperty("redisHost");
        int port=getPropertyToInt("redisPort");
        int timeout=10000;
        String redisPass=getProperty("redisPass");
        // 用于缓存bbs模块的redis服务
        RedisPlugin ktvRedisPlugin = new RedisPlugin(cacheName, host, port, timeout, redisPass);

        plugins.add(druidPlugin);
        plugins.add(activeRecordPlugin);
        plugins.add(ktvRedisPlugin);

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }

    @Override
    public void onStart() {

        WxaConfig wc = new WxaConfig();
        wc.setAppId(getProperty("appId"));
        wc.setAppSecret(getProperty("appSecret"));
        WxaConfigKit.setWxaConfig(wc);

        super.onStart();
    }
}
