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

> `Задание 4.` Установить и затем удалить deb-пакет, используя команду `dpkg`.

```bash
# Скачиваем deb-пакет (например, htop)
wget http://security.ubuntu.com/ubuntu/pool/main/h/htop/htop_3.2.2-1_amd64.deb

# Устанавливаем пакет
sudo dpkg -i htop_3.2.2-1_amd64.deb

# Удаляем пакет
sudo dpkg -r htop
```

> `Задание 5.` История команд в терминале Ubuntu  
 Сохранить и выложить [историю команд](./command_history.txt) в терминале Ubuntu.  
 В формате: Файла с ФИО, датой сдачи, номером группы(или потока)
```bash
# Создаем файл с личной информацией и историей команд
{
    echo "ФИО: "
    echo "Дата сдачи: "
    echo "Номер группы: "
    echo ""
    echo "История команд:"
    history
} > command_history.txt

# Проверяем содержимое файла
cat command_history.txt
```

> `Задание 6.` Создать диагрaмму клаcсов с родительским классом "Живoтные", и двумя подклассaми: "Pets" и "Pack animals".
В сoставы клaссов котoрых в случае Pets войдут классы: собаки, кошки, хомяки, а в клaсс Pack animals войдут: Лошади, верблюды и oслы.
![Task 6](./Diagram.PNG)

> `Задание 7.` Cоздать базу данных с названием "Human Friends".
```sql
CREATE DATABASE IF NOT EXISTS Human_Friends;
USE Human_Friends;   
```  

> `Задание 7.1.` Создать таблицы, соответствующие иерархии из вашей диаграммы классов.
```sql
CREATE TABLE Pets (
    ID INT PRIMARY KEY,
    Name VARCHAR(50),
    Type VARCHAR(20),
    BirthDate DATE,
    Commands VARCHAR(100)
);

CREATE TABLE PackAnimals (
    ID INT PRIMARY KEY,
    Name VARCHAR(50),
    Type VARCHAR(20),
    BirthDate DATE,
    Commands VARCHAR(100)
);
```
> `Задание 7.2.` Заполнить таблицы данными о животных, их командах и датами рождения.
```sql
INSERT INTO Pets VALUES
(1, 'Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
(2, 'Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
(3, 'Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
(4, 'Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
(5, 'Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
(6, 'Peanut', 'Hamster', '2021-08-01', 'Roll, Spin'),
(7, 'Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
(8, 'Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');


INSERT INTO PackAnimals VALUES
(1, 'Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
(2, 'Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
(3, 'Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
(4, 'Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
(5, 'Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
(6, 'Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'),
(7, 'Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
(8, 'Sahara', 'Camel', '2015-08-14', 'Walk, Run');
```   
> `Задание 7.3.` Удалить записи о верблюдах и объединить таблицы лошадей и ослов.
```sql
CREATE TABLE HorsesAndDonkeys AS
SELECT * FROM PackAnimals WHERE Type IN ('Horse', 'Donkey');
```
> `Задание 7.4.` Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.
```sql
CREATE TABLE YoungAnimals AS
SELECT 
    Name,
    Type,
    BirthDate,
    Commands,
    TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeInMonths,
    CONCAT(
        FLOOR(TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) / 12), ' лет ',
        MOD(TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()), 12), ' месяцев'
    ) AS Age
FROM (
    SELECT * FROM Pets
    UNION ALL
    SELECT * FROM PackAnimals
) AS AllAnimals
WHERE BirthDate BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) 
    AND DATE_SUB(CURDATE(), INTERVAL 1 YEAR);
```
> `Задание 7.5.` Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.   
```sql
CREATE TABLE AllAnimals AS
SELECT 
    Name,
    Type,
    BirthDate,
    Commands,
    'Домашние животные' AS SourceTable
FROM Pets
UNION ALL
SELECT 
    Name,
    Type,
    BirthDate,
    Commands,
    'Вьючные животные' AS SourceTable
FROM PackAnimals;
```
