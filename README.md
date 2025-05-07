# ExposiCionWeb
#Para instalar IntelliJ:

Instalamos de la pagina oficial

Descomprimimos con tar -xzvf

Cambiamos el nombre con mv idea-IC-251.23774.435/ idea

Lo movemos a /opt/   sudo mv idea /opt/

Buscamos ejecutable y el logo cd /opt/idea/bin

Hacemos cd .local/share/applications

Hacemos 

sudo nano intellij.desktop

Pegamos: 

```
[Desktop Entry]
Type=Application
Categories=Development
Name=IntelliJ IDEA
Comment=Community Edition
Icon=/opt/idea/bin/idea.png
Exec=/opt/idea/bin/idea.sh
Terminal=false
```


#Para instalar Postman

Instalamos de la pagina oficial

Descomprimimos con tr -xzvf

Cambiamos nombre conn mv

Movemos a opt 

Hacemos cd .local/share/applications

sudo nano Postman.desktop

```
[Desktop Entry]
Type=Application
Categories=Development
Name=Postman
Comment=API Platform
Icon=/opt/Postman/app/icons/icon_128x128.png
Exec=/opt/Postman/Postman
Terminal=false
```
