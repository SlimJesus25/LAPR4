/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.elearning.infrastructure.bootstrapers.demo;

import java.util.HashSet;
import java.util.Set;
import eapli.elearning.infrastructure.bootstrapers.UsersBootstrapperBase;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;
/**
 * @author Paulo Gandra Sousa
 */
public class BackofficeUsersBootstrapper extends UsersBootstrapperBase implements Action {

    @SuppressWarnings("squid:S2068")
    private static final String PASSWORD1 = "Password1";

    @Override
    public boolean execute() {

        registerAdministrator("gabriel", PASSWORD1, "Gabriel", "Silva", "gabi-ultra-hd@gmail.com");
        registerAdministrator("vicente", PASSWORD1, "Vicente", "Teixeira", "vicente_delas@gmail.com");
        registerAdministrator("krillin", PASSWORD1, "Diogo", "Magalhaes", "krillin_magalhaes@gmail.com");
        registerAdministrator("ricardo", PASSWORD1, "Ricardo", "Peixoto", "avozinha@gmail.com");
        registerAdministrator("venancio", PASSWORD1, "Ricardo", "Venancio", "venas@gmail.com");

        registerTeacher("vicenteT", PASSWORD1, "VicenteT", "TeixeiraT", "c@gmail.com");
        registerTeacher("krillinT", PASSWORD1, "DiogoT", "MagalhaesT", "krillin_magalhaesT@gmail.com");
        registerTeacher("ricardoT", PASSWORD1, "RicardoT", "PeixotoT", "avozinhaT@gmail.com");
        registerTeacher("venancioT", PASSWORD1, "RicardoT", "VenancioT", "a@gmail.com");
        registerTeacher("gabrielT", PASSWORD1, "GabrielT", "SilvaT", "b@gmail.com");

        registerStudent("guisauce", PASSWORD1, "Guilherme", "Afonso", "guisauce2002@gmail.com");
        registerStudent("vasco", PASSWORD1, "Vasco", "Pinto", "vasco@gmail.com");
        registerStudent("pedro", "Logotipo1", "Pedro", "Alexandrino", "pedroalex@gmail.com");

        return true;
    }

    private void registerAdministrator(final String username, final String password,
                                 final String firstName, final String lastName, final String email){
        final Set<Role> roles = new HashSet<>();
        roles.add(ElearningRoles.ADMINISTRATOR);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerTeacher(final String username, final String password,
                                 final String firstName, final String lastName, final String email){
        final Set<Role> roles = new HashSet<>();
        roles.add(ElearningRoles.TEACHER);
        roles.add(ElearningRoles.ELEARNING_USER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerStudent(final String username, final String password,
                                 final String firstName, final String lastName, final String email){
        final Set<Role> roles = new HashSet<>();
        roles.add(ElearningRoles.STUDENT);
        roles.add(ElearningRoles.ELEARNING_USER);

        registerUser(username, password, firstName, lastName, email, roles);
    }
}
