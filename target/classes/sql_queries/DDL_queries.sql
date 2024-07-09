create table if not exists CREDENTIALS(
    username varchar(30) primary key,
    password varchar(1000)
);

create table if not exists persons(
	person_id	numeric(3,0),
    first_name	varchar(25),
    last_name 	varchar(25),
    mob_no		numeric(10,0),
    address 	varchar(100),
    date_of_birth 	date,
    primary key (person_id)
    );
    
create table if not exists courts (
	court_id	numeric(3,0),
    address		varchar(100),
    primary key (court_id)
    );
    
create table if not exists crimes (
	offense_id 		numeric(3,0),
    offense_name 	varchar(20),
    primary key (offense_id)
    );
    
create table if not exists lawyers (
	lawyer_id	numeric(3,0),
    person_id	numeric(3,0),
    court_id	numeric(3,0),
    primary key (lawyer_id),
    foreign key (person_id) references persons(person_id) on delete cascade on update cascade,
    foreign key (court_id) references courts(court_id) on delete cascade on update cascade
    );

create table if not exists judges (
	judge_id	numeric(3,0),
    person_id	numeric(3,0),
    court_id	numeric(3,0),
    primary key (judge_id),
    foreign key (person_id) references persons(person_id) on delete cascade on update cascade,
    foreign key (court_id) references courts(court_id) on delete cascade on update cascade
    );

create table if not exists cases (
	case_id numeric(3,0),
    court_id numeric(3,0),
    prosecution_lawyer_id numeric(3,0),
    defending_lawyer_id numeric(3,0),
    judge_id numeric(3,0),
    case_status varchar(20),
    start_date date,
    end_date date,
    next_hearing date,
    offense_id numeric(3,0),
    primary key (case_id),
    foreign key (court_id) references courts(court_id) on delete cascade on update cascade,
    foreign key (prosecution_lawyer_id) references lawyers(lawyer_id) on delete cascade on update cascade,
    foreign key (defending_lawyer_id) references lawyers(lawyer_id) on delete cascade on update cascade,
    foreign key (judge_id) references judges(judge_id) on delete cascade on update cascade,
    foreign key (offense_id) references crimes(offense_id) on delete cascade on update cascade
    );
    
create table if not exists witnesses (
	witness_id 	numeric(3,0),
    person_id 	numeric(3,0),
    case_id		numeric(3,0),
    primary key (witness_id),
    foreign key (person_id) references persons(person_id) on delete cascade on update cascade,
    foreign key (case_id) references cases(case_id) on delete cascade on update cascade
    );