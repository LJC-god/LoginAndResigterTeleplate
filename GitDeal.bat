@echo off
echo Running Git commands...

REM 添加所有修改
git add .

REM 提示用户输入提交注释
set /p commit_message="push your annotation now "

REM 提交更改
git commit -m "%commit_message%"

REM 推送到 GitHub 上的 master 分支
git push -u github master

REM 推送到 origin 上的 master 分支
git push -u origin master

echo Git commands executed successfully.
pause
