Проект по изучению Spring 2024
# Автор Логинов Владислав
Java version: 21.0.1, vendor: Eclipse Adoptium
Apache Maven 3.9.6
Spring Boot 3.3.0
OS name: "windows 10", version: "10.0", arch: "amd64"

## Приложение DiscountApp
Приложение для покупки товаров, с возможностью уменьшения цены

### Архитектура приложения
	Для приложения была выбрана слоевая архитектура состоящая из следующих слоев:
	Доменный слой (domain) - классы выражающие сущности из модели предметной области, 
	относящейся к программе, и реализующие бизнес-логику программы.
	Слой приложения  (app) - классы сервисов и интерфейсы репозиториев.
	Внешний слой (external) -  классы (контроллеры), отвечающие за работу с API 
	и классы данных для общения с пользователем  (DTO).

### Биснес-модель (логика):
	1. Объекты: зарегистрированный пользователь(два или более), администратор(один), главный менеджер(один), 
	менеджер(ноль или более), покупатель(ноль или более), пользователь (вероятнее всего покупатель)
	(ноль или более), маркетинговая программа, товар, запрос уменьшения цены (основаная задача), заказ;
	2. Маркетинговая программа - это правила, которые должен выполнить зарегистрированный покупатель, 
	для получения специальных условий при покупке товаров;
	3. Товар - предмет(или вещество), определенный количеством или объемом, либо услуга. Товар может быть 
	трех типов: предварительный(заведенный любым менеджером, отображается у главного менеджера, 
	администратора и у менеджера, который изначально создал данный товар), проверенный (товар, 
	прошедший проверку главным менеджером, отображается у главного менеджера, администратора и 
	у менеджера, который изначально создал данный товар), выставленный на продажу (товар, 
	прошедший проверку администратором, отображается у всех пользователей);
	4. Запрос уменьшения цены формируется любым пользователем. Пользователь должен пройти регистрацию. 
	Отправляется на согласование прикрепленному менеджеру. По сути это три объекта с разной степенью скидки 
	и дополнительным согласованием;
	5. Заказ - товар, выбранный, оплаченный, полученный или удаленный  покупателем. 
	6. Условия регистрации: ввести контактный телефон и новый пароль.
	7. Условия входа для зарегистрированных пользователей: ввести контактный телефон и пароль.

### Роли:
	Администратор
	Главный менеджер
	Менеджер
	Покупатель
	Пользователь
	Зарегистрированный пользователь
	
### Логика распределения ролей:
	1. Пользователь - любой кто зашел на сайт приложения. Если пользователь совершает покупку, он становится 
	покупателем(уточнить контактный данные во время покупки);
	2. Зарегистрированный пользователь - пользователь прошедший регистрацию. Зарегистрированный 
	пользователь является и пользователем; 
	3. Главный менеджер назначается администратором на этапе становления и вносится в список 
	зарегистрированных пользователей. Главный менеджер является также менеджером и зарегистрированным 
	пользователем;
	4. Менеджер назначается главным менеджером из списка зарегистрированных пользователей, также является 
	зарегистрированным пользователем;
	5. Покупатель - это пользователь, намеревающийся совершить покупку, является также пользователей, может 
	быть зарегистрированным пользователей;
	6. Администратор - первый зарегистрированный пользователь становится администратором, также является 
	зарегистрированным пользователем.
	
### Права доступа:
	Администратор 
			Товар( удаление, подтверждение)
			Пользователь(просмотр, удаление, роли)
			Покупатель(просмотр, удаление, добавление эклюзивных условий покупки товаров)
			Маркетинговая программа(удаление, подтверждение)
			Менеджер(просмотр, удаление, роли)
			Главный менеджер(просмотр, удаление, роли, подтверждение)
	Главный менеджер
			Товар( подтверждение)
			Пользователь(просмотр, роли(ограничено администратором))
			Покупатель(просмотр, переназначение)
			Маркетинговая программа(удаление(если не подтверждена администратором), создание)
			Менеджер(просмотр, удаление, роли(ограничено администратором))
			Запрос уменьшения цены(подтверждение, перенаправление к администратору(при троичном уменьшении 
			цены))
	Менеджер
			Товар( создание)
			Покупатель(просмотр(только прикрепленных))
			Запрос уменьшения цены(просмотр(только прикрепленных), перенаправление к главному менеджеру
			(при вторичном уменьшении цены))
			Заказ(просмотр)
	Покупатель
			Менеджер(просмотр(только прикрепленных))
			Заказы(просмотр, удаление)
			История заказов(просмотр, удаление)
	Зарегистрированный пользователь
			Покупатель(просмотр самого себя)
			Запрос уменьшения цены(создание, удаление)
			Маркетинговая программа(участие)
	Пользователь
			Запрос уменьшения цены(просмотр)
			Маркетинговая программа(просмотр)
			Товар(просмотр, покупка)


