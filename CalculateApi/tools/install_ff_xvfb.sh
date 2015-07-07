INSTALLED=`yum info xorg-x11-server-Xvfb | grep installed`
if [ "$INSTALLED" == "" ];
then
  echo "Xvfb not installed will install"
  sudo yum -y install xorg-x11-server-Xvfb
else 
  echo "Xvfb installed already"
fi

INSTALLED=`yum info firefox | grep installed`
if [ "$INSTALLED" == "" ];
then
  echo "Firefox is not installed, installing..."
  sudo yum -y install firefox
else
  echo "Firefox is installed"
fi


RUN_COMMAND="Xvfb :99 -screen 0 1920x1200x24"
EXPORT_COMMAND="export DISPLAY=:99"

IS_NOT_STARTED=`ps -ef | grep Xvfb | grep screen`
if [ "$IS_NOT_STARTED" == "" ];
then
  echo "Starting Xvfb..."
  $RUN_COMMAND &
  $EXPORT_COMMAND
else 
  echo "Xvfb is already started"
fi

RC_SCRIPT=/etc/rc.d/rc.local
PROFILE_SCRIPT=/etc/profile.d/xvfb.sh

STARTUP_ADDED=`cat $RC_SCRIPT | grep Xvfb`
if [ "$STARTUP_ADDED" == "" ];
then
  echo "Adding Xvfb command to $RC_SCRIPT script for auto startup..."
  echo "$RUN_COMMAND &" | sudo tee -a $RC_SCRIPT
else 
  echo "Xvfb command is already present in $RC_SCRIPT"
fi

PROFILE_ADDED=`cat $PROFILE_SCRIPT | grep DISPLAY`
if [ "$PROFILE_ADDED" == "" ];
then
  echo "Adding DISPLAY variable to $PROFILE_SCRIPT script for auto startup..."
  echo "$EXPORT_COMMAND" | sudo tee -a $PROFILE_SCRIPT
else 
  echo "DISPLAY variable is already present in $PROFILE_SCRIPT"
fi

echo "Installation of Xvfb and Firefox is complete."
