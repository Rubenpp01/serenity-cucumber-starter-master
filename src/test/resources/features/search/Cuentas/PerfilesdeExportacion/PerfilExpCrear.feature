@all

  @PerfilExportacionCrear

  Feature: Perfil de Exportación - Crear

    Background:
      Given "User" abre la página web
      When Inicia sesión con las credenciales "CB000000117","REPENUELPRE","BOGOTA05*"
      Then Debe iniciar sesión correctamente en corporate "<mensajeEsperado>"

    Scenario Outline: Creación de Perfil de Exportación

      When Navega al módulo de cuentas selecciona la opción "PERFILES DE EXPORTACIÓN"
      When Completar el formulario del perfil con "<descripcionperfil>","<nombreperfil>"
      Then Validacion mensaje de confirmación Perfil"<PerfilcreadoExitosa>"

      Examples:
        | descripcionperfil          | nombreperfil    |
        | Perfil Exportacion 3       | Perfil Expo 3   |



