cd C:\code
mkdir Exercice_CLI
cd .\Exercice_CLI\
touch fichier1.txt
touch fichier2.txt
touch fichier3.txt
ls
mkdir SousDossier
cp fichier1.txt SousDossier/fichier1.txt
mv fichier2.txt nouveau_fichier.txt
mv nouveau_fichier.txt SousDossier/nouveau_fichier.txt
rm .\SousDossier\ -r
cd ..
rm .\Exercice_CLI\ -r