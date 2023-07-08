package eapli.elearning.usermanagement.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.criteria.CriteriaBuilder;
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class TaxPayNumber {
    Integer num;
    public TaxPayNumber(int num){

        if (validationTaxPayNumber(num)){
            this.num=num;
        }
    }
    public boolean validationTaxPayNumber(int num){
        return true;
    }
}
