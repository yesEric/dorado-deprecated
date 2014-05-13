package cn.dorado.cms.application;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(
        locations = {"classpath:/applicationContext-resources.xml",
                "classpath:/applicationContext-dao.xml",
                "classpath:/applicationContext-service.xml",
                
                "classpath:**/applicationContext*.xml"}
)
public class BaseApplicationTestCase extends AbstractTransactionalJUnit4SpringContextTests{

	
    /**
     * 为所有子类提供一个日志类.
     */
    protected final Log log = LogFactory.getLog(getClass());
    /**
     * ResourceBundle 从 src/test/resources/${package.name}/ClassName.properties 加载(如果有)
     */
    protected ResourceBundle rb;
    /**
     * 从资源文件中加载JavaBean格式的资源信息的助手方法，实质上是进行对象属性的拷贝.
     *
     * @param obj 要加载资源文件的对象
     * @return 根据资源文件信息装载后的对象.
     * @throws Exception 如果复制对象属性失败抛出异常.
     */
    protected Object populate(final Object obj) throws Exception {
        // loop through all the beans methods and set its properties from its .properties file
        Map<String, String> map = new HashMap<String, String>();

        for (Enumeration<String> keys = rb.getKeys(); keys.hasMoreElements(); ) {
            String key = keys.nextElement();
            map.put(key, rb.getString(key));
        }

        BeanUtils.copyProperties(obj, map);

        return obj;
    }
}
