package test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Path("/hello")
public class HelloRest {
	@GET
	public String hello() {
		return "Hello world @ " + new Date().toString();
	}
	
	@POST
	public String helloPost() {
		return "Hello world post @ " + new Date().toString();
	}
	
	@Path("/student")
	@GET
	@Produces("application/json")
	public Student getStudent() {
		return new Student("ivan", "ivanov");
	}
}

@Provider
@Produces("application/json")
class JSONBodyWriter implements MessageBodyWriter<Student> {
	
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        System.out.println("isWriteable called...");
        return type == Student.class;
    }
  
    @Override
    public long getSize(Student myBool, Class<?> type, Type genericType,
                        Annotation[] annotations, MediaType mediaType) {
        // deprecated by JAX-RS 2.0 and ignored by Jersey runtime
        return 0;
    }
  
    
    @Override
    public void writeTo(Student st,
                        Class<?> type,
                        Type genericType,
                        Annotation[] annotations,
                        MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders,
                        OutputStream entityStream)
                        throws IOException, WebApplicationException {
  
        StringBuilder sb = new StringBuilder();
        sb.append("{\"fn\":\"").append(st.getFn()).append("\",\"ln\":\"").append(st.getLn()).append("\"}");
        DataOutputStream dos = new DataOutputStream(entityStream);
        dos.writeUTF(sb.toString());
    }
}
