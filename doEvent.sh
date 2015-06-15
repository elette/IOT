ps -ef| grep Standalone | grep Event | awk '{system("kill " $2)}'
source ~/.bashrc
nohup /opt/ibm/InfoSphere_Streams/4.0.0.0/java/bin/java -jar /home/streamsadmin/workspace/IOT/output/IOT.Event/Standalone/IOT.Event.sab -c &
