echo "Prueba de regresión en progreso para RegressionController.seleccionarSalas"
# Retorna N salas de una reservacion definida por un id dado.

../INITIAL_STATE_SCRIPT.sh state_001.sql
echo "(***) Estado Inicial establecido !!!"

echo "(***) Invocando al endpoint para comparar el hash del objeto que genera la respuesta..."
HASH=-2042063312

DATA=( $(\
curl -s \
-X GET --header "Accept: application/json;charset=utf-8" \
"https://cinepolis.ultrasist.net/api/seleccionar-sala.json?id=10" \
| jq '.hash'))

if [ $DATA = $HASH ]
    then
      echo "VERIFICACIÓN CORRECTA !!!"
    else
      echo "FALLO LA VERIFICACIÓN :("
fi

../RESTORE_PREV_STATE.sh

