-- changeSet создаём таблицу
CREATE TABLE IF NOT EXISTS mail (

    id SERIAL NOT NULL,
    name varchar(20),
    email varchar(50),
    date_of_birth DATE,
    primary key (id));

-- changeSet добавляем столбец
ALTER TABLE customers
ADD  column IF NOT EXISTS sex varchar(10) NOT NULL default 'неизвестен'

