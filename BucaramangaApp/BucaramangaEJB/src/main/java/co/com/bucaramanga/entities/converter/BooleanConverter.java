package co.com.bucaramanga.entities.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class BooleanConverter implements AttributeConverter<Boolean, String>{
	
	private static final String SI = "S";
	private static final String NO = "N";

	@Override
	public String convertToDatabaseColumn(Boolean data) {
		if (data != null) {
			return data ? SI : NO;
		}
		return NO;
	}

	@Override
	public Boolean convertToEntityAttribute(String data) {
		return SI.equalsIgnoreCase(data);
	}

}
