ps -ef| grep Standalone | grep Main | awk '{system("kill " $2)}'
nohup /opt/ibm/InfoSphere_Streams/4.0.0.0/java/bin/java -jar /home/streamsadmin/workspace/IOT/output/IOT.Main/Standalone/IOT.Main.sab -c &
