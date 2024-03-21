CREATE SCHEMA ssafy_test;

use ssafy_test;

#movie 라는 테이블이 존재하지 않으면 생성
create table if not exists movie (
#기본 키 는 id
    id int(10) not null AUTO_INCREMENT primary key,
    title varchar(40) character set utf8mb4 not null,
    genre varchar(10) not null,
    runningtime int(3) not null,
    releasedate date
)engine = InnoDB;

# comment 라는 테이블이 존재하지 않으면 생성
create table if not exists ratinginfo (
    movie_id int not null,
    name varchar(30) not null,
    rating int not null,
    comment varchar(50) not null,
# 기본 키는 movie_id, name 두가지를 조합
    primary key (movie_id, name),
# board_num 은 board 테이블의 board_num 컬럼을 참조하는 외래 키
    constraint `fk_ratinginfo_movie`
        foreign key (movie_id)
        references movie (id)
        on delete cascade
        on update cascade
)engine = InnoDB;

