package cn.dorado.cms.domain.model.common;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;

import cn.dorado.util.DateUtil;

@SuppressWarnings("serial")
public class DomainException extends RuntimeException {
	private static Log log = LogFactory.getLog(DomainException.class);
	String domainId;
	public DomainException(String message){
		super(message);
	}
	public DomainException(String messageKey,String domainId){
		
		 Locale locale = LocaleContextHolder.getLocale();
	        String message;
	        try {
	        	message = ResourceBundle.getBundle("ApplicationResources", locale)
	                    .getString(messageKey);
	        } catch (MissingResourceException mse) {
	        	message = "Error found at domain";
	        }
		
		log.debug(message+":"+domainId);
		throw new RuntimeException(message);
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

}
