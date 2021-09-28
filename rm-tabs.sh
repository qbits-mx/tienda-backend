#!/bin/bash

#
# Script para remplazar los tabs por cuatro espacios en blanco
#
# autor: GAA
#

rm -rf .DS_Store

if [ $# == 1 ]; then
    if [ -d $1 ]; then
    IFS=$'\n'
    EXT_TMP="-rem.tmp"

    for I in $(find $1 -type f -not -path '.git' -iname '*.*'); do
        NUM=$(file $I | cut -d ':' -f 2 | grep -i text | wc -l)

        if [ $NUM -eq "1" ]; then
            echo "Procesando: $I"
            FILE_TEMP=$I$EXT_TMP
            sed -e 's/'"$(printf '\011')"'/    /g' $I > $FILE_TEMP
            sed -e 's/[ '"$(printf '\011')"']*$//g' $FILE_TEMP > $I
            rm $FILE_TEMP
        else
            echo "Se omite el archivo" $I
        fi
    done
    else
    echo "El parámetro debe ser un directorio"
    fi
else
    echo "Se requiere un argumento:"
    echo "   remplazaTabs.sh <directorio>"
    exit 1;
fi


