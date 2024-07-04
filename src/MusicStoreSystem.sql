create table Customer(
    CustomerId SMALLINT,
    CustomerName VARCHAR(30),
    CustomerEmail VARCHAR(30),
    CustomerPhone VARCHAR(30),
    CustomerAddr VARCHAR(30),
    constraint pk_Customer PRIMARY KEY(CustomerId)
);
create table Album(
    AlbumId SMALLINT,
    ArtistId SMALLINT,
    Title VARCHAR(30),
    ReleaseDate VARCHAR(30),
    Price SMALLINT,
    Genre VARCHAR(30),
    constraint pk_Album PRIMARY KEY (AlbumId)
);
create table Artist(
    ArtistId SMALLINT,
    ArtistName VARCHAR(30),
    ArtistCountry VARCHAR(30),
    constraint pk_Artist PRIMARY KEY(ArtistId)
);
CREATE TABLE CustomerOrder (
    OrderId SMALLINT,
    CustomerId SMALLINT,
    TotalAmount SMALLINT,
    AlbumId SMALLINT,
    CONSTRAINT pk_Order PRIMARY KEY (OrderId),
    CONSTRAINT fk_CustomerId FOREIGN KEY (CustomerId) REFERENCES Customer(CustomerId),
    CONSTRAINT fk_AlbumId FOREIGN KEY (AlbumId) REFERENCES Album(AlbumId)
);
INSERT INTO Customer (
        CustomerID,
        CustomerName,
        CustomerEmail,
        CustomerPhone,
        CustomerAddr
    )
VALUES (
        1,
        'John',
        'john77@yahoo.com',
        '987654321',
        'Beaker street london'
    ),
    (
        2,
        'Mike',
        'Mike88@yahoo.com',
        '987654322',
        'kings street new york'
    ),
    (
        3,
        'Smith',
        'smith99@gmail.com',
        '987654323',
        'hauz khas Delhi'
    ),
    (
        4,
        'Buttler',
        'buttler66@yahoo.com',
        '987654324',
        'lords cricket ground london'
    );
INSERT INTO Artist (ArtistId, ArtistName, ArtistCountry)
VALUES (201, 'Ed Sheeran', 'ENGLAND'),
    (202, 'Taylor Swift', 'US'),
    (203, 'Eminem', 'US'),
    (204, 'Arjit Singh', 'INDIA');

INSERT INTO Album (
        AlbumId,
        ArtistId,
        Title,
        ReleaseDate,
        Price,
        Genre
    )
VALUES (101, 201, 'Divide', '26_May_2003', '1000', 'Pop'),
    (
        102,
        202,
        'Heaven',
        '11_June_2008',
        '1500',
        'EDM'
    ),
    (
        103,
        203,
        'Life',
        '7_October_2016',
        '2300',
        'Rock'
    ),
    (104, 204, 'Nights', '16_May_2017', '3000', 'EDM');



ALTER table Album
add constraint fk_ArtistId FOREIGN KEY (ArtistId) REFERENCES  Artist(ArtistId);