package six;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by changheng on 17/9/15.
 */
public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

    private Set<String> obscenities;
    public ObscenityRemovingBeanFactoryPostProcessor(){
        this.obscenities = new HashSet<>();
    }

    /**
     * Modify the application context's internal bean factory after its standard
     * initialization. All bean definitions will have been loaded, but no beans
     * will have been instantiated yet. This allows for overriding or adding
     * properties even to eager-initializing beans.
     *
     * @param beanFactory the bean factory used by the application context
     * @throws BeansException in case of errors
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for(String beanName : beanDefinitionNames){
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            StringValueResolver resolver = strVal -> {
                if(isObscene(strVal)){
                    return "*******";
                }
                return strVal;
            };
            new BeanDefinitionVisitor(resolver).visitBeanDefinition(beanDefinition);

        }
    }

    public boolean isObscene(Object value){
        String potentialObscenity = value.toString().toUpperCase();
        return this.obscenities.contains(potentialObscenity);
    }

    public void setObscenities(Set<String> obscenities) {
        this.obscenities.clear();
        for(String obscenity : obscenities){
            this.obscenities.add(obscenity.toUpperCase());
        }
    }
}
