/*Create Table Ingredient*/
CREATE TABLE public."Ingredient"
(
  id integer NOT NULL,
  name text,
  CONSTRAINT "Ingredient_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Ingredient"
  OWNER TO postgres;
ALTER TABLE public."Ingredient"
  ADD CONSTRAINT "Ingredient_pkey" PRIMARY KEY(id);
  /*Create Table Meal*/
  CREATE TABLE public."Meal"
(
  name text,
  category text,
  price integer,
  weight integer,
  ingridient_id integer[],
  id integer NOT NULL,
  CONSTRAINT "Meal_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Meal"
  OWNER TO postgres;
ALTER TABLE public."Meal"
  ADD CONSTRAINT "Meal_pkey" PRIMARY KEY(id);

  /*Create table Menu*/
CREATE TABLE public."Menu"
(
  name text,
  meal_id integer[]
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Menu"
  OWNER TO postgres;

  /*Create Table Order*/
  CREATE TABLE public."Order"
(
  id integer NOT NULL,
  list_meal text[],
  "table" integer,
  date date,
  oficiant_id integer,
  CONSTRAINT "Order_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Order"
  OWNER TO postgres;
ALTER TABLE public."Order"
  ADD CONSTRAINT "Order_pkey" PRIMARY KEY(id);
  
  /*Create table Pile*/
  CREATE TABLE public."Pile"
(
  id bigint,
  amount integer,
  ingredient_id integer NOT NULL,
  CONSTRAINT "Pile_pkey" PRIMARY KEY (ingredient_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Pile"
  OWNER TO postgres;
ALTER TABLE public."Pile"
  ADD CONSTRAINT "Pile_pkey" PRIMARY KEY(ingredient_id);

  /*Create table Prepared_meal*/
  CREATE TABLE public."Prepared_meal"
(
  id integer NOT NULL,
  meal_id integer,
  staff_id integer,
  order_id integer,
  date date,
  CONSTRAINT "Prepared_meal_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Prepared_meal"
  OWNER TO postgres;
ALTER TABLE public."Prepared_meal"
  ADD CONSTRAINT "Prepared_meal_pkey" PRIMARY KEY(id);
  
  /*Create table Staff*/
  CREATE TABLE public."Staff"
(
  family text,
  name text,
  date_birthday date,
  phone integer,
  "position" text,
  salary integer,
  id integer NOT NULL,
  CONSTRAINT "Staff_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Staff"
  OWNER TO postgres;
ALTER TABLE public."Staff"
  ADD CONSTRAINT "Staff_pkey" PRIMARY KEY(id);

  
/* Fill Staff*/
INSERT INTO public."Staff" (family,name,date_birthday,phone,position,salary,id) Values('Чучупака','Василь','1913-07-07','0697894516','менеджер','7000','1');
INSERT INTO public."Staff" (family,name,date_birthday,phone,position,salary,id) Values('Заболотний','Семен','1921-05-05','0697894516','офіціант','3000','2');
INSERT INTO public."Staff" (family,name,date_birthday,phone,position,salary,id) Values('Гришин','Петро','1965-10-10','069712345','офіціант','3000','3');
INSERT INTO public."Staff" (family,name,date_birthday,phone,position,salary,id) Values('Гризло','Іван','1921-05-05','0697894516','повар','6000','4');
INSERT INTO public."Staff" (family,name,date_birthday,phone,position,salary,id) Values('Шнирь','Ольга','1921-05-05','0697894516','повар','6000','5');
INSERT INTO public."Staff" (family,name,date_birthday,phone,position,salary,id) Values('Кузик','Вадим','1987-11-11','0697894516','бармен','5000','6');
INSERT INTO public."Staff" (family,name,date_birthday,phone,position,salary,id) Values('Мудрий','Ярослав','1955-05-15','0697894516','менеджер','10000','7');

/*Fill Meal*/
INSERT INTO public."Meal" (name,category,ingridient_id,price,weight) Values('Борщ','первші страви','{1,2}','20','300');
INSERT INTO public."Meal" (name,category,ingridient_id,price,weight) Values('Cуп грибний','перші страви','{1,4}','20','300');
INSERT INTO public."Meal" (name,category,ingridient_id,price,weight) Values('Каша','другі страви','{8}','20','250');
INSERT INTO public."Meal" (name,category,ingridient_id,price,weight) Values('Компот','напої','{7,9}','20','200');
INSERT INTO public."Meal" (name,category,ingridient_id,price,weight) Values('Мармелад','десерт','{9,10}','20','150');

/*Fill Ingredients*/
INSERT INTO public."Ingredient" (id,name) Values('1','Картопля');
INSERT INTO public."Ingredient" (id,name) Values('2','Буряк');
INSERT INTO public."Ingredient" (id,name) Values('3','Мясо');
INSERT INTO public."Ingredient" (id,name) Values('4','Гриби');
INSERT INTO public."Ingredient" (id,name) Values('5','Мука');
INSERT INTO public."Ingredient" (id,name) Values('6','Масло');
INSERT INTO public."Ingredient" (id,name) Values('7','Сухофрукти');
INSERT INTO public."Ingredient" (id,name) Values('8','Гречка');
INSERT INTO public."Ingredient" (id,name) Values('9','Цукор');
INSERT INTO public."Ingredient" (id,name) Values('10','Желатин');


/*Fill Pile*/
INSERT INTO public."Pile" (amount,ingredient_id) VALUES('5000','1');
INSERT INTO public."Pile" (amount,ingredient_id) VALUES('2000','2');
INSERT INTO public."Pile" (amount,ingredient_id) VALUES('1000','3');
INSERT INTO public."Pile" (amount,ingredient_id) VALUES('500','4');
INSERT INTO public."Pile" (amount,ingredient_id) VALUES('10000','5');
INSERT INTO public."Pile" (amount,ingredient_id) VALUES('200','6');
INSERT INTO public."Pile" (amount,ingredient_id) VALUES('700','7');
INSERT INTO public."Pile" (amount,ingredient_id) VALUES('1000','8');
INSERT INTO public."Pile" (amount,ingredient_id) VALUES('5000','9');
INSERT INTO public."Pile" (amount,ingredient_id) VALUES('250','10');


/*Fill Menu*/
INSERT INTO public."Menu" () VALUES ('Перші страви','');
INSERT INTO public."Menu" () VALUES ('Десерти','');


/*Fill Order*/
/*Fill Prepared meal*/
/**/
/**/
/**/
/**/