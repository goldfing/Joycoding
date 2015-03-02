#!/bin/sh

rsync -rtzv . mindmaps@192.168.33.10:~/app/
ssh mindmaps@192.168.33.10 sudo restart mindmaps
