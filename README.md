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

