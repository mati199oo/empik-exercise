package component.domain.mapper;

import component.domain.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ERROR)
public interface UserMapper {

    component.view.model.User domainToView(User user);

//    User githubToDomain(component.github.model.User githubUser);
}
