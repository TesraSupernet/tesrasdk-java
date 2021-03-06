<h1 align="center"> Governance </h1>

<p align="center" class="version">Version 1.0.0 </p>

[English](../cn/governance.md) / English

## Interface list


### Apply to become a candidate node
#### Mortgage a certain TSG, consume a certain amount of additional TSG, apply to become a candidate node

```
String registerCandidate(Account account, String peerPubkey, long initPos, String tstid,String tstidpwd,byte[] salt,  long keyNo, Account payerAcct, long gaslimit, long gasprice)
```
	Parameters:
  
| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | account       | Account | peer wallet account            | Required |
|         | peerPubkey    | String  | peer publickey               | Required |
|         | initPos       | long    | init pos             |Required|
|         | tstid         | String  |authorized tstid          | Required|
|         | tstidpwd      | String  | tstid password              |Required|
|         | salt          | byte[]  | salt        |Required|
|         | keyNo         | long    | publickey index               |Required|
|         | payerAcct     | Account | account for payment of transaction fees     |Required|
|         | gaslimit      | long    | gaslimit | Required |
|         | gasprice      | long    | gas price               | Required|
| output | transactionhash| String  | transaction hash  |  |


#### Cancel the application to become a candidate node, unfreeze the mortgaged TSG
```
String unRegisterCandidate(Account account, String peerPubkey,Account payerAcct, long gaslimit, long gasprice)
```

	Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | account       | Account | peer wallet account            | Required |
|         | peerPubkey    | String  | peer publickey              | Required |
|         | payerAcct     | Account | account for payment of transaction fees |Required|
|         | gaslimit      | long    | gaslimit | Required |
|         | gasprice      | long    | gas price           | Required|
| output | transaction hash| String  | transaction hash  |  |


#### Extract unbound TSG
```
String withdrawTsg(Account account,Account payerAcct,long gaslimit,long gasprice)
```

  Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | account       | Account | peer wallet account         | Required |
|         | payerAcct     | Account | account for payment of transaction fees      |Required|
|         | gaslimit      | long    | gaslimit | Required |
|         | gasprice      | long    | gas price               | Required|
| output | transaction hash       | String  | transaction hash  |  |

#### Redeem rewards of stake authorization
```
String withdrawFee(Account account,Account payerAcct,long gaslimit,long gasprice)
```

Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | account       | Account | peer wallet account         | Required |
|         | payerAcct     | Account | account for payment of transaction fees      |Required|
|         | gaslimit      | long    | gaslimit | Required |
|         | gasprice      | long    | gas price               | Required|
| output | transaction hash       | String  | transaction hash  |  |


#### Query node information
```
String getPeerInfo(String peerPubkey)
```

	Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | peerPubkey     | String | peer publickey| Required |
| output | peer information       | String  | peer information  |  |


#### Query all node information
```
String getPeerInfoAll()
```

return value: all nodes information



#### Query the authorization information of a certain address to a node
```
String getAuthorizeInfo(String peerPubkey,Address addr)
```

	Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | peerPubkey    | String | peer publickey      | Required |
|         | addr    | String| adddress               | Required |
| output |       | String  | peer AuthorizeInfo  |  |


#### Take out the mortgage TSG in an unfrozen state
```
String quitNode(Account account,String peerPubkey,Account payerAcct,long gaslimit,long gasprice)
```
	Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | account       | Account | peer wallet account            | Required |
|         | peerPubkey    | String  | peer public key               | Required |
|         | payerAcct     | Account | account for payment of transaction fees      |Required|
|         | gaslimit      | long    | gaslimit| Required |
|         | gasprice      | long    | gas price               | Required|
| output | transaction hash       | String  | transaction hash  |  |


#### addInitPos interface (can only be called by the node owner)
```
String addInitPos(Account account,String peerPubkey,int pos,Account payerAcct,long gaslimit,long gasprice)
```

	Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | account       | Account   | peer wallet account     | Required |
|         | peerPubkey    | String  | peer public key               | Required |
|         | pos           | int     | Add the number of tst mortgages      | Required |
|         | payerAcct     | Account | account for payment of transaction fees    |Required|
|         | gaslimit      | long    | gaslimit| Required |
|         | gasprice      | long    | gas price               | Required|
| output | transaction hash       | String  | transaction hash  |  |


#### reduceInitPos (can only be called by the node owner)
The initPos cannot be lower than the promised value, and cannot be lower than 1/10 of the accepted number of licenses.
```
String reduceInitPos(Account account,String peerPubkey,int pos,Account payerAcct,long gaslimit,long gasprice)
```
	Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | account       | Account | peer wallet account          | Required |
|         | peerPubkey    | String  | peer public key              | Required |
|         | pos           | int     | Reduce the number of tst mortgages       | Required |
|         | payerAcct     | Account | account for payment of transaction fees     |Required|
|         | gaslimit      | long    | gaslimit| Required |
|         | gasprice      | long    | gas price               | Required|
| output | transaction hash       | String  | transaction hash  |  |


#### setPeerCost
The node sets the proportion of its own exclusive incentives
```
String setPeerCost(Account account,String peerPubkey,int peerCost,Account payerAcct,long gaslimit,long gasprice)
```
	Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | account       | Account | peer wallet account            | Required |
|         | peerPubkey    | String  | peer public key               | Required |
|         | peerCost      | int     | The proportion of nodes themselves       | Required |
|         | payerAcct     | Account | account for payment of transaction fees |Required|
|         | gaslimit      | long    | gaslimit| Required |
|         | gasprice      | long    | gas price               | Required|
| output | transaction hash       | String  | transaction hash  |  |


#### changeMaxAuthorization
The node modifies the maximum number of authorized TSG nodes it accepts
```
String changeMaxAuthorization(Account account,String peerPubkey,int maxAuthorize,Account payerAcct,long gaslimit,long gasprice)
```

	Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | account       | Account | peer wallet account  | Required |
|         | peerPubkey    | String  | peer public key               | Required |
|         | maxAuthorize  | int     | The maximum number of authorized tst nodes accepted by the node itself | Required |
|         | payerAcct     | Account | account for payment of transaction fees      |Required|
|         | gaslimit      | long    | gaslimit| Required |
|         | gasprice      | long    | gas price   | Required|
| output | transaction hash       | String  | transaction hash  |  |


#### Query node attribute information
```
String getPeerAttributes(String peerPubkey)
```

	Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | peerPubkey    | String |peer public key | Required |
| output |        | String  | peer attribute information  |  |


#### Query the incentives for an address
```java
String getSplitFeeAddress(String address)
```

	Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | address    | String | address            | Required |
| output |        | String  | Query the incentives for an address  |  |

### Authorize stake for some node

Authorize stake for some node
```java
String authorizeForPeer(Account account,String peerPubkey[],long[] posList,Account payerAcct,long gaslimit,long gasprice)
```

Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | account       | Account | peer wallet account            | Required |
|         | peerPubkey    | String[]  | peer public key               | Required |
|         | posList       | long[]     |   Mortgage interest     | Required |
|         | payerAcct     | Account | account for payment of transaction fees |Required|
|         | gaslimit      | long    | gaslimit| Required |
|         | gasprice      | long    | gas price               | Required|
| output | transaction hash       | String  | transaction hash  |  |

### unAuthorize stake for some node

unAuthorize stake for some node
```java
String unAuthorizeForPeer(Account account,String peerPubkey[],long[] posList,Account payerAcct,long gaslimit,long gasprice)
```

Parameters:

| Parameter| Field   | Type  | description |          instruction |
| ----- | ------- | ------ | ------------- | ----------- |
| input | account       | Account | peer wallet account            | Required |
|         | peerPubkey    | String[]  | peer public key               | Required |
|         | posList       | long[]     |   Mortgage interest     | Required |
|         | payerAcct     | Account | account for payment of transaction fees |Required|
|         | gaslimit      | long    | gaslimit| Required |
|         | gasprice      | long    | gas price               | Required|
| output | transaction hash       | String  | transaction hash  |  |