
package com.vsked.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SayHiService", targetNamespace = "http://service.vsked.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SayHiService {


    /**
     * 
     * @param name
     */
    @WebMethod(operationName = "SayHi")
    @Action(input = "http://service.vsked.com/SayHiService/SayHiRequest", output = "http://service.vsked.com/SayHiService/SayHiResponse")
    public void sayHi(
        @WebParam(name = "name", partName = "name")
        String name);

    /**
     * 
     * @param clientTime
     * @return
     *     returns int
     */
    @WebMethod(operationName = "CheckTime")
    @WebResult(name = "valid", partName = "valid")
    @Action(input = "http://service.vsked.com/SayHiService/CheckTimeRequest", output = "http://service.vsked.com/SayHiService/CheckTimeResponse")
    public int checkTime(
        @WebParam(name = "clientTime", partName = "clientTime")
        XMLGregorianCalendar clientTime);

    /**
     * 
     */
    @WebMethod(operationName = "SayHiDefault")
    @Action(input = "http://service.vsked.com/SayHiService/SayHiDefaultRequest", output = "http://service.vsked.com/SayHiService/SayHiDefaultResponse")
    public void sayHiDefault();

}
