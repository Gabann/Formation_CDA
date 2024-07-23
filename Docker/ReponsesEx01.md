# Utilisez la commande Docker pour créer un container basé sur l'image Alpine.
docker create --name alpine alpine

# Connectez-vous au shell du container nouvellement créé.
docker run -it alpine

# À l'intérieur du container, utilisez la commande git pour cloner un dépôt public depuis GitHub (par exemple, https://github.com/votre-utilisateur/exemple-repo.git).
apk add git
git clone https://github.com/Gabann/ECF-4

# Allez dans le répertoire du dépôt cloné.
cd ECF-4

# À l'intérieur du container, ouvrez un fichier texte (par exemple, README.md) à l'aide d'un éditeur de texte disponible dans l'image Alpine.
apk add nano
nano README.md

# Depuis votre terminal local, utilisez la commande Docker pour copier le fichier modifié depuis le container vers votre machine locale, dans un répertoire de votre choix.
docker cp alpine:/ECF-4 C:\Users\Administrateur\Desktop
