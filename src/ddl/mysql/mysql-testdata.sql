use wormhole;

INSERT INTO tblRoute (
  RouteName,
  RouteDesc, 
  RouteEnabled, 
  RoutePriority,
  StartDate, 
  StopDate, 
  Period,
  CreatedByUser,
  LastModifiedDate,
  LastModifiedUser) 
VALUES (
  'Sirius Express',
  'Non-Stop Service to Sirius',
  1,
  1,
  CURRENT_TIMESTAMP,
  '2020-03-12', 
  60000, 
  'tmonkey',
  CURRENT_TIMESTAMP,
  'tmonkey');
  
INSERT INTO tblRoute (
  RouteName,
  RouteDesc, 
  RouteEnabled, 
  RoutePriority,
  StartDate, 
  StopDate, 
  Period,
  CreatedByUser,
  LastModifiedDate,
  LastModifiedUser) 
VALUES (
  'Libra Express',
  'Non-Stop Service to Libra',
  1,
  10,
  CURRENT_TIMESTAMP,
  '2020-03-12', 
  60000, 
  'tmonkey',
  CURRENT_TIMESTAMP,
  'tmonkey');
  
INSERT INTO tblRoute (
  RouteName,
  RouteDesc, 
  RouteEnabled, 
  RoutePriority,
  StartDate, 
  StopDate, 
  Period,
  CreatedByUser,
  LastModifiedDate,
  LastModifiedUser) 
VALUES (
  'Nunki Express',
  'Non-Stop Service to Nunki',
  0,
  2,
  CURRENT_TIMESTAMP,
  '2020-03-12', 
  60000, 
  'tmonkey',
  CURRENT_TIMESTAMP,
  'tmonkey');  

INSERT INTO tblRouteJob (
  RouteID,
  TraversalCount,
  Acknowledged )
VALUES (
  1,
  10,
  0
);

INSERT INTO tblRouteJob (
  RouteID,
  TraversalCount,
  Acknowledged )
VALUES (
  1,
  15,
  0
);

INSERT INTO tblRouteJob (
  RouteID,
  TraversalCount,
  Acknowledged )
VALUES (
  2,
  100,
  0
);

INSERT INTO tblRouteJob (
  RouteID,
  TraversalCount,
  Acknowledged )
VALUES (
  3,
  2,
  0
);

INSERT INTO tblRouteJob (
  RouteID,
  TraversalCount,
  Acknowledged )
VALUES (
  3,
  6,
  0
);