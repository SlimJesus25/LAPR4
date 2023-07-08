package eapli.elearning.postitmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Properties;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@Embeddable
public class PostItColumn implements ValueObject {
    private Integer columnP;
    private static Integer MAX_COLUMN;

    public PostItColumn(Integer column) {
        try{
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties.sample"));
            MAX_COLUMN = Integer.parseInt(properties.getProperty("col_max"));
        }catch (Exception e){
            // NOTA: Para que não haja necessidade de cercar com um "try catch" lançam-se exceções "unchecked".
            throw new NullPointerException("An error occurred loading the property files.");
        }
        verifyColumn(column);
        this.columnP = column;
    }
    // TODO : Verificar se excede o tamanho máximo definido por configuração.
    private void verifyColumn(Integer column){
        if(column < 0){
            throw new IllegalArgumentException("Column can't be negative!");
        }
        if(column > MAX_COLUMN){
            throw new IllegalArgumentException("Column can't be superior than " + MAX_COLUMN);
        }
    }

    protected PostItColumn() {
    }

    public Integer column() {
        return columnP;
    }
}
