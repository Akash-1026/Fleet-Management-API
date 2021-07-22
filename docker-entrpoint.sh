#!/usr/bin/sh
touch /config/application.properties

if [ -d /run/secrets/ ]; then
  for filename in /run/secrets/*; do
    echo "${filename##*/}=`cat $filename`" >> /config/appliation.properties
  done
fi

echo "Properties created, running $@"

sh -c "$@"
#create secrets using docker swarm to use this file for accesing those secrets