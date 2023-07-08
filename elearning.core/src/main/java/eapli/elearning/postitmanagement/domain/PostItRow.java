package eapli.elearning.postitmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Properties;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
@Embeddable
public class PostItRow implements ValueObject {
    private Integer rowP;
    private static Integer MAX_ROW;

    public PostItRow(Integer row) {
        try{
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties.sample"));
            MAX_ROW = Integer.parseInt(properties.getProperty("row_max"));
        }catch (Exception e){
            // NOTA: Para que não haja necessidade de cercar com um "try catch" lançam-se exceções "unchecked".
            throw new NullPointerException("An error occurred loading the property files.");
        }
        verifyRow(row);
        this.rowP = row;
    }

    // TODO : Verificar se excede o tamanho máximo definido por configuração.
    private void verifyRow(Integer row){
        if(row < 0){
            throw new IllegalArgumentException("Row can't be negative!");
        }
        if(row > MAX_ROW){
            throw new IllegalArgumentException("Column can't be superior than " + MAX_ROW);
        }
    }

    protected PostItRow() {
    }

    public Integer row() {
        return rowP;
    }
}
