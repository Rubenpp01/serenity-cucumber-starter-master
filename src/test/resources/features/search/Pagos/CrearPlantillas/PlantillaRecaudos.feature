@all

  @RecaudoExitoso

  Feature: Plantillas Recaudos

    Background:
      Given "User" abre la página web
      When Inicia sesión con las credenciales "CB000000117","REPENUELPRE","BOGOTA04*"
      Then Debe iniciar sesión correctamente en corporate "<mensajeEsperado>"

    Scenario Outline: Creación de Plantilla recaudo unico beneficiario existente

      When Navega al módulo de pagos y plantillas selecciona la opción "RECAUDOS DIRECTOS"
      When Completar el formulario de recaudos con "<nombreplantilla>","<limiteRec>","<monto>","<numeroref>"
      When Ingreso de la contraseña "<clavePagos>" y confirma el recaudo
      Then Validacion mensaje de confirmación "<creacionExitosa>"

      Examples:
        | nombreplantilla   | limiteRec | monto    |  numeroref  |clavePagos    | creacionExitosa|
        | Plantilla Reca 3  | 1000000   | 103.090  |   2322      | BOGOTA04*    | Acción Exitosa |


      @PlantillaRecaudosinMonto
    Scenario Outline: Creación de Plantilla recaudo sin monto

      When Navega al módulo de pagos y plantillas selecciona la opción "RECAUDOS DIRECTOS"
      When Completar el formulario de recaudos con "<nombreplantilla>","<limiteRec>","<monto>","<numeroref>"
      When Ingreso de la contraseña "<clavePagos>" y confirma el recaudo
      Then Validacion mensaje de error "<mensajeError>"

        Examples:
          | nombreplantilla      | limiteRec | monto    |  numeroref   |clavePagos    | mensajeError        |
          | Recaudo sin monto 3  | 1000000   |          |   2326       | BOGOTA04*    | Plantilla sin monto |

      @PlantillaValidaccionLimites
    Scenario Outline: Creación de Plantilla recaudo con monto superior al límite

      When Navega al módulo de pagos y plantillas selecciona la opción "RECAUDOS DIRECTOS"
      When Completar el formulario de recaudos con "<nombreplantilla>","<limiteRec>","<monto>","<numeroref>"
      When Ingreso de la contraseña "<clavePagos>" y confirma el recaudo
      Then Validacion mensaje de error "<mensajeError>"

        Examples:
          | nombreplantilla    | limiteRec | monto    |  numeroref   |clavePagos    | mensajeError                        |
          | Recaudo Limite     | 10        | 1000001  |   3326       | BOGOTA04*    | El monto supera el límite permitido |


