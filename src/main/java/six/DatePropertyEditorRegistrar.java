package six;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.DataBinder;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by changheng on 17/9/15.
 */
public class DatePropertyEditorRegistrar implements PropertyEditorRegistrar {
    /**
     * Register custom {@link PropertyEditor PropertyEditors} with
     * the given {@code PropertyEditorRegistry}.
     * <p>The passed-in registry will usually be a {@link BeanWrapper} or a
     * {@link DataBinder DataBinder}.
     * <p>It is expected that implementations will create brand new
     * {@code PropertyEditors} instances for each invocation of this
     * method (since {@code PropertyEditors} are not threadsafe).
     *
     * @param registry the {@code PropertyEditorRegistry} to register the
     *                 custom {@code PropertyEditors} with
     */
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}
