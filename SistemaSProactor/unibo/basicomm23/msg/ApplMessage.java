package unibo.basicomm23.msg;

import org.json.simple.JSONObject;

import alice.tuprolog.Struct;
import alice.tuprolog.Term;
import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.utils.ColorsOut;
import unibo.basicomm23.utils.CommUtils;
 


public class ApplMessage implements IApplMessage {
    protected String msgId       = "";
    protected String msgType     = null;
    protected String msgSender   = "";
    protected String msgReceiver = "";
    protected String msgContent  = "";
    protected int msgNum         = 0;
    
    protected Interaction conn;		//not null for request
	
	public ApplMessage( 
			String MSGID, String MSGTYPE, String SENDER, String RECEIVER,
            String CONTENT, String SEQNUM ) {
        msgId 		= MSGID;
        msgType 	= MSGTYPE;
        msgSender 	= SENDER;
        msgReceiver = RECEIVER;	
        msgContent 	= CONTENT;
        msgNum      = Integer.parseInt(SEQNUM);		
	}
    public ApplMessage(
            String MSGID, String MSGTYPE, String SENDER, String RECEIVER,
            String CONTENT, String SEQNUM, Interaction conn ) {
	    this(MSGID,  MSGTYPE,  SENDER,  RECEIVER,  CONTENT, SEQNUM);
	    this.conn = conn;
    }
    public ApplMessage( String msg ) {
        //msg( MSGID, MSGTYPE, SENDER, RECEIVER, CONTENT, SEQNUM )
        //CommUtils.outcyan("ApplMessage CREATE " + msg);
        
        try {
        	JSONObject jm   = CommUtils.parseForJson( msg );
        	            msgId    = jm.get("msgId").toString();
        	            msgType  = jm.get("msgType").toString();
						msgSender = jm.get("msgSender").toString();
						msgReceiver = jm.get("msgReceiver").toString();
						msgContent = jm.get("msgContent").toString();
						msgNum = Integer.parseInt(jm.get("msgNum").toString());
		} catch (Exception e) {
			//CommUtils.outmagenta("ApplMessage | not a json message " + msg);
	        Struct msgStruct = (Struct) Term.createTerm(msg);
	        setFields(msgStruct); //potrebbe lanciare eccezione
		}
    }
 
	public void setConn( Interaction conn ) {
		if( isRequest() || isReply()) this.conn = conn;
		else ColorsOut.out("WARNING: setting conn not allowed");
	}
	public Interaction getConn(   ) {
		return conn;
	}	
	

	
    private void setFields( Struct msgStruct ) {
    	//CommUtils.outmagenta("ApplMessage | setFields " + msgStruct);
        msgId 		= msgStruct.getArg(0).toString();
        msgType 	= msgStruct.getArg(1).toString();
        msgSender 	= msgStruct.getArg(2).toString();
        msgReceiver = msgStruct.getArg(3).toString();
        msgContent 	= msgStruct.getArg(4).toString();
        msgNum 		= Integer.parseInt(msgStruct.getArg(5).toString());
    }

    public String msgId() {   return msgId; }
    public String msgType() { return msgType; }
    public String msgSender() { return msgSender; }
    public String msgReceiver() { return msgReceiver;  }
    public String msgContent() { return msgContent;  }
    public String msgNum() { return "" + msgNum; } 
    
    
    public boolean isEvent(){
        return msgType.equals( ApplMessageType.event.toString() );
    }
    public boolean isDispatch(){
        return msgType.equals( ApplMessageType.dispatch.toString() );
    }
    public boolean isRequest(){
        return msgType.equals( ApplMessageType.request.toString() );
    }
    public boolean isInvitation(){
        return msgType.equals( ApplMessageType.invitation.toString() );
    }
    public boolean isReply(){
        return msgType.equals( ApplMessageType.reply.toString() );
    }   
    
    public String toString() {
    	return "msg($msgId,$msgType,$msgSender,$msgReceiver,$msgContent,$msgNum)"
    			.replace("$msgId",msgId).replace("$msgType",msgType)
    			.replace("$msgSender",msgSender).replace("$msgReceiver",msgReceiver)
    			.replace("$msgContent",msgContent).replace("$msgNum",""+msgNum);
    }

    public String toJsonString() {
    	return "{\"msgId\":\"MID\",\"msgType\":\"MTYPE\",\"msgSender\":\"MSENDER\",\"msgReceiver\": \"MRECEIVER\",\"msgContent\":\"MCONTENT\",\"msgNum\":\"MNUM\"}"
    			.replace("MID",msgId).replace("MTYPE",msgType)
    			.replace("MSENDER",msgSender).replace("MRECEIVER",msgReceiver)
    			.replace("MCONTENT",msgContent).replace("MNUM",""+msgNum);
    }
    
	public static ApplMessage cvtJson(String msjson) {
		JSONObject jm   = CommUtils.parseForJson( msjson );
		String MSGID    = jm.get("msgId").toString();
		String MSGTYPE  = jm.get("msgType").toString();
		String SENDER   = jm.get("msgSender").toString();		
        String RECEIVER = jm.get("msgReceiver").toString();
        String CONTENT  = jm.get("msgContent").toString();
        String SEQNUM   = jm.get("msgNum").toString();
       	
		ApplMessage m = new ApplMessage(MSGID, MSGTYPE, SENDER, RECEIVER, CONTENT, SEQNUM);		 
		return m;
	}

}
