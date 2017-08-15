package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Autenticador {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param usuario
	 * @param senha
	 * @return Var
	 */
	// Autenticador
	public static Var Autenticar(Var usuario, Var senha) throws Exception {
		return new Callable<Var>() {

			private Var logar = Var.VAR_NULL;
			private Var autenticar = Var.VAR_NULL;
			private Var autenticar2 = Var.VAR_NULL;

			public Var call() throws Exception {
				logar = Var.VAR_FALSE;
				autenticar = cronapi.util.Operations.getHeadersFromExternalURL(Var.valueOf("POST"),
						Var.valueOf("application/x-www-form-urlencoded"),
						Var.valueOf("https://janus-i.techne.com.br/webservices/rest/login"), cronapi.map.Operations
								.createObjectMapWith(Var.valueOf("usuario", usuario), Var.valueOf("senha", senha)),
						Var.VAR_NULL);
				autenticar2 = cronapi.util.Operations.getURLFromOthers(Var.valueOf("POST"),
						Var.valueOf("application/x-www-form-urlencoded"),
						Var.valueOf("https://janus-i.techne.com.br/webservices/rest/login"), cronapi.map.Operations
								.createObjectMapWith(Var.valueOf("usuario", usuario), Var.valueOf("senha", senha)),
						Var.VAR_NULL);
				cronapi.util.Operations.getValueFromSession(Var.valueOf("header"),
						cronapi.conversion.Operations.toString(autenticar));
				System.out.println(
						cronapi.util.Operations.getValueFromSession(Var.valueOf("header")).getObjectAsString());
				if (Var.valueOf(autenticar2.equals(Var.valueOf("Usuário autenticado com sucesso")))
						.getObjectAsBoolean()) {
					logar = Var.VAR_TRUE;
				}
				return logar;
			}
		}.call();
	}

}
