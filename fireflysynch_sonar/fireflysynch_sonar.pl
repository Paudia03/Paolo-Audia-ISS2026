%====================================================================================
% fireflysynch_sonar description   
%====================================================================================
dispatch( cellstate, cellstate(X,Y,COLOR) ).
event( obstacle, obstacle(DIST) ).
event( synch, synch(X) ).
event( desynch, desynch(X) ).
%====================================================================================
context(ctxfirefly, "localhost",  "TCP", "8040").
context(ctxgrid, "127.0.0.1",  "TCP", "8050").
 qactor( griddisplay, ctxgrid, "external").
  qactor( sonar, ctxfirefly, "it.unibo.sonar.Sonar").
 static(sonar).
  qactor( sonarhandler, ctxfirefly, "it.unibo.sonarhandler.Sonarhandler").
 static(sonarhandler).
  qactor( firefly1, ctxfirefly, "it.unibo.firefly1.Firefly1").
 static(firefly1).
  qactor( firefly2, ctxfirefly, "it.unibo.firefly2.Firefly2").
 static(firefly2).
  qactor( firefly3, ctxfirefly, "it.unibo.firefly3.Firefly3").
 static(firefly3).
