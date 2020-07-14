@echo off
cls

set TOKEN="ChuyenPhuong1023@27281997"
set REMOTE="miostore-ptit.herokuapp.com"
set LOCALPORT="8080"

cd ..
cd bin
inlets.exe client --remote="%REMOTE%" --token "%TOKEN%" --upstream=http://127.0.0.1:%LOCALPORT%
pause
