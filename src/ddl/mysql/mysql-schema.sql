USE wormhole;

CREATE TABLE tblAppConfigType (
  AppConfigTypeID   SMALLINT      PRIMARY KEY,
  ConfigTypeName    VARCHAR(256)  NOT NULL
);

CREATE TABLE tblAppConfig (
  AppConfigID       INTEGER       AUTO_INCREMENT PRIMARY KEY,
  AppConfigHost     VARCHAR(256)  NOT NULL,
  AppConfigTypeID   SMALLINT      NOT NULL,
  AppConfigValInt   INTEGER       NULL,
  AppConfigValChar  VARCHAR(256)  NULL,
  CONSTRAINT fk_tblAppConfig_tblAppConfigType FOREIGN KEY (AppConfigTypeID) REFERENCES tblAppConfigType(AppConfigTypeID)
);

CREATE TABLE tblRoute (
  RouteID           INTEGER       AUTO_INCREMENT PRIMARY KEY,
  RouteName         VARCHAR(100)  NOT NULL,
  RouteDesc         VARCHAR(2048) NULL,
  RouteEnabled      INTEGER       DEFAULT 0,
  RoutePriority     TINYINT       DEFAULT 1,
  StartDate         DATETIME      NOT NULL,
  StopDate          DATETIME      NOT NULL,
  Period            INTEGER       DEFAULT 60000,
  CreateDate        TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
  CreatedByUser     VARCHAR(256)  NOT NULL,
  LastModifiedDate  DATETIME      NOT NULL,
  LastModifiedUser  VARCHAR(256)  NOT NULL
);

CREATE TABLE tblRouteConfigType (
  RouteConfigTypeID SMALLINT      PRIMARY KEY,
  ConfigTypeName    VARCHAR(256)  NOT NULL
);

INSERT INTO tblRouteConfigType VALUES (0, 'Source');
INSERT INTO tblRouteConfigType VALUES (1, 'Target');

CREATE TABLE tblRouteConfig (
  RouteConfigID     INTEGER       AUTO_INCREMENT PRIMARY KEY,
  RouteID           INTEGER       NOT NULL,
  RouteConfigTypeID SMALLINT      NOT NULL,
  CreateDate        TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
  CreatedByUser     VARCHAR(256)  NOT NULL,
  LastModifiedDate  DATETIME      NOT NULL,
  LastModifiedUser  VARCHAR(256)  NOT NULL,
  CONSTRAINT fk_tblRouteConfig_tblRoute FOREIGN KEY (RouteID) REFERENCES tblRoute(RouteID),
  CONSTRAINT fk_tblRouteConfig_tblRouteConfigType FOREIGN KEY (RouteConfigTypeID) REFERENCES tblRouteConfigType(RouteConfigTypeID)
);

CREATE TABLE tblRouteConfigAttr (
  RouteConfigAttrID INTEGER      AUTO_INCREMENT PRIMARY KEY,
  RouteConfigID    INTEGER       NOT NULL,
  AttributeID      INTEGER       NOT NULL,
  AttributeValue   VARCHAR(2048) NOT NULL,
  CreateDate        TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
  CreatedByUser     VARCHAR(256)  NOT NULL,
  LastModifiedDate  DATETIME      NOT NULL,
  LastModifiedUser  VARCHAR(256)  NOT NULL,
  CONSTRAINT fk_tblRouteConfigAttr_tblRouteConfig FOREIGN KEY (RouteConfigID) REFERENCES tblRouteConfig(RouteConfigID)
);

CREATE TABLE tblRouteJob (
  RouteJobID       INTEGER       AUTO_INCREMENT PRIMARY KEY,
  RouteID          INTEGER       NOT NULL,
  TraversalCount   INTEGER       NOT NULL,
  Acknowledged     INTEGER       NOT NULL DEFAULT 0,
  CONSTRAINT fk_tblRouteJob_tblRoute FOREIGN KEY (RouteID) REFERENCES tblRoute(RouteID)
);
CREATE INDEX idxRouteJob_RouteID ON tblRouteJob (RouteID, Acknowledged);

CREATE TABLE tblEventType (
  EventTypeID      SMALLINT      PRIMARY KEY,
  EventTypeName    VARCHAR(50)   NOT NULL
);

INSERT INTO tblEventType VALUES (0, 'INFO');
INSERT INTO tblEventType VALUES (1, 'WARN');
INSERT INTO tblEventType VALUES (2, 'ERROR');
INSERT INTO tblEventType VALUES (3, 'FATAL');

CREATE TABLE tblEvent (
  EventID          INTEGER       AUTO_INCREMENT PRIMARY KEY,
  RouteID          INTEGER       NOT NULL,
  EventTypeID      SMALLINT      NOT NULL,
  EventCode        VARCHAR(16)   NOT NULL,
  EventMessage     VARCHAR(2048) NOT NULL,
  CreateDate       TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
  Acknowledged     INTEGER       NOT NULL DEFAULT 0,
  CONSTRAINT fk_tblEvent_tblRoute FOREIGN KEY (RouteID) REFERENCES tblRoute(RouteID),
  CONSTRAINT fk_tblEvent_tblEventType FOREIGN KEY (EventTypeID) REFERENCES tblEventType(EventTypeID)
);
CREATE INDEX idxEvent_RouteID_EventTypeID ON tblEvent (RouteID, EventTypeID, Acknowledged);