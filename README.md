 ## Информация о проекте
 Необходимо организовать систему учета для питомникa в кoтoром живут домашние и вьючныe животныe. 


### Задание 

> `Задание 1.` Создать два текстовых фaйла: "Pets"(Дoмашние живoтные) и "Pack animals"(вьючныe животные), используя команду `cat` в терминале Linux.   
   В первом файле перечислить собак, кошек и хомяков.  
   Во втором — лошадей, верблюдов и ослов.
```bash
# Создаем файл Pets.txt
cat > Pets.txt << EOF
Собаки
Кошки
Хомяки
EOF

# Создаем файл PackAnimals.txt
cat > PackAnimals.txt << EOF
Лошади
Верблюды
Ослы
EOF
```
> Объединить содержимое этих двух файлов в один и просмотреть его содержимое.
```bash
# Объединяем файлы и просматриваем содержимое
cat Pets.txt PackAnimals.txt > Animals.txt
cat Animals.txt
```

> Переименовать получившийся файл в "Human Friends".
Показать пример конечного вывода после команды “ls” :
```bash
# Переименовываем файл
mv Animals.txt "Human Friends.txt"

# Проверяем результат
ls
 Desktop    'Human Friends.txt'   Pictures        
 Documents   Music                Public                  
 Downloads   PackAnimals.txt      Templates
 gitrepo     Pets.txt             Videos

```

> `Задание 2.` Создать новую директорию и переместить туда файл "Human Friends".
```bash
# Создаем новую директорию
mkdir NewDirectory

# Перемещаем файл
mv "Human Friends.txt" NewDirectory/

# Проверяем результат
ls NewDirectory/
```

> `Задание 3.` Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”  
Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.
```bash
# Добавляем репозиторий MySQL
wget https://dev.mysql.com/get/mysql-apt-config_0.8.26-1_all.deb
sudo dpkg -i mysql-apt-config_0.8.26-1_all.deb

# Устанавливаем MySQL
sudo apt update
sudo apt install mysql-server
```
