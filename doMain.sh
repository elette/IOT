#ps -ef| grep Standalone | grep Main | awk '{system("kill " $2)}'
#nohup /opt/ibm/InfoSphere_Streams/4.0.0.0/java/bin/java -jar /home/streamsadmin/workspace/IOT/output/IOT.Main/Standalone/IOT.Main.sab -c &
source ~/.bashrc
#streamtool canceljob `streamtool lsjobs | grep IOT::Main | awk '{print $1}'`
#streamtool submitjob /home/streamsadmin/workspace/IOT/output/IOT.Main/Distributed/IOT.Main.sab

PEID=`streamtool lspe | grep LogFile | awk '{print $1}'`
streamtool stoppe $PEID
streamtool restartpe $PEID
