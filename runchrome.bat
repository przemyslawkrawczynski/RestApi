call runcrud.bat
if "%ERRORLEVEL%" == "0" goto fail

call start chrome "http://localhost:8080/crud/v1/task/getTasks"
if "%ERRORLEVEL%" == "0" goto fail

:fail
echo.
echo Something went wrong.

:end
echo.
echo Work is finished.