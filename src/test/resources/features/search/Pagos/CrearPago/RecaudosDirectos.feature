@all

  Feature: Recaudos Directos

    Background:
      Given "User" abre la página web
      When Inicia sesión con las credenciales "CB000000117","RPENUEL","BOGOTA02*"
      Then Debe iniciar sesión correctamente en corporate "<mensajeEsperado>"

    Scenario Outline: Creación de recaudo directo unico beneficiario existente

      When Navega al módulo de pagos y selecciona la opción "RECAUDOS DIRECTOS"
      When Llena el formulario de recaudos directos con "<monto>","<numeroref>"
      When Ingresa la contraseña "<clavePagos>" y confirma el recaudo
      Then Visualiza mensaje de confirmación "<creacionExitosa>"

      Examples:
        | monto    |  numeroref  |clavePagos    | creacionExitosa|
        | 103.090  |   2322      | BOGOTA02*    | Acción Exitosa |


