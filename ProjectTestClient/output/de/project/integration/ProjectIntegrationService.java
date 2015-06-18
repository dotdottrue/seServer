package de.project.integration;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.13
 * 2015-06-18T21:07:06.456+02:00
 * Generated source version: 2.7.13
 * 
 */
@WebServiceClient(name = "ProjectIntegrationService", 
                  wsdlLocation = "http://localhost:8080/project/ProjectIntegration?wsdl",
                  targetNamespace = "http://integration.project.de/") 
public class ProjectIntegrationService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://integration.project.de/", "ProjectIntegrationService");
    public final static QName ProjectIntegrationPort = new QName("http://integration.project.de/", "ProjectIntegrationPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/project/ProjectIntegration?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ProjectIntegrationService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/project/ProjectIntegration?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ProjectIntegrationService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ProjectIntegrationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProjectIntegrationService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ProjectIntegrationService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ProjectIntegrationService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ProjectIntegrationService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ProjectIntegration
     */
    @WebEndpoint(name = "ProjectIntegrationPort")
    public ProjectIntegration getProjectIntegrationPort() {
        return super.getPort(ProjectIntegrationPort, ProjectIntegration.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProjectIntegration
     */
    @WebEndpoint(name = "ProjectIntegrationPort")
    public ProjectIntegration getProjectIntegrationPort(WebServiceFeature... features) {
        return super.getPort(ProjectIntegrationPort, ProjectIntegration.class, features);
    }

}
