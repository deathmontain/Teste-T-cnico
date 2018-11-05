package br.com.jonatas.devjava.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.jonatas.devjava.modelo.Item;
import br.com.jonatas.devjava.persistence.ItemPersistence;

@FacesConverter("itemConverter")
public class ItemConverter implements Converter {

	private ItemPersistence itemPersistence = new ItemPersistence();
	
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String newValue) {
        if(newValue != null) {
        	return itemPersistence.encontrar(Integer.parseInt(newValue));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object == null) {
            return "";
        }
        if (object instanceof Item) {
        	Item item = (Item) object;
        	return item.getOid().toString();
            
        } else {
            throw new ConverterException(new FacesMessage(object + " is not a valid item"));
        }
    }
}