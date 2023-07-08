package eapli.base.persistence.impl.jpa;

import eapli.elearning.studentmanagement.domain.StudentMechanographicalNumber;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import java.io.Serializable;
import java.util.Properties;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class MechanographicalNumberSequenceGenerator extends SequenceStyleGenerator {

    public static final String CODE_NUMBER_SEPARATOR_PARAMETER = "codeNumberSeparator";
    public static final String CODE_NUMBER_SEPARATOR_DEFAULT = "-";

    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
    public static final String NUMBER_FORMAT_DEFAULT = "%05d";
    private String format;

    @Override
    public Serializable generate(final SharedSessionContractImplementor session, final Object object)
        throws HibernateException {
        final var prefix = ((StudentMechanographicalNumber) object).studentMechanograpicalNumber();
        // TODO sequence should be dependent of the prefix
        final var seq = super.generate(session, object);
        return String.format(format, prefix, seq);
    }

    @Override
    public void configure(final Type type, final Properties params, final ServiceRegistry serviceRegistry)
            throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        final String codeNumberSeparator = ConfigurationHelper.getString(CODE_NUMBER_SEPARATOR_PARAMETER, params,
                CODE_NUMBER_SEPARATOR_DEFAULT);
        final String numberFormat = ConfigurationHelper
                .getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT).replace("%", "%2$");
        this.format = "%1$s" + codeNumberSeparator + numberFormat;
    }
}
