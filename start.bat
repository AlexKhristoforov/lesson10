@>nul MD ".\dist
     @>nul javac -sourcepath ./src -d dist  src/by/itacademy/hospital/*.java
     java -cp dist by.itacademy.hospital.Main
     @>nul RD /s/q ".\dist
     pause