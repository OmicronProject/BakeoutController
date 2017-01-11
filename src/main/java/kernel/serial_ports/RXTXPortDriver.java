package kernel.serial_ports;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.RXTXPort;
import kernel.serial_ports.comm_port_wrapper.CommPortWrapper;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Driver responsible for managing serial port names
 */
public class RXTXPortDriver implements PortDriver {
    private final String applicationName;
    private final CommPortWrapper portWrapper;

    public RXTXPortDriver(String applicationName, CommPortWrapper portWrapper){
        this.applicationName = applicationName;
        this.portWrapper = portWrapper;
    }

    @Override public String getApplicationName(){
        return this.applicationName;
    }

    @Override public List<String> getSerialPortNames(){
        Enumeration portIdentifiers = this.portWrapper.getPortIdentifiers();
        List<CommPortIdentifier> identifierList = castPortIdentsToList(
            portIdentifiers);

        List<CommPortIdentifier> serialPortList = filterForSerialPorts(
                identifierList
        );

        return getPortNamesForList(serialPortList);
    }

    @Override public SerialPort getPortByName(String portName) throws
            NoSuchPortException, PortInUseException {

        RXTXPort portToWrap = new RXTXPort(portName);
        return new RXTXPortWrapper(portToWrap);
    }

    private ArrayList<CommPortIdentifier> castPortIdentsToList(
            Enumeration commPortIdentifiers
    ){
        ArrayList<CommPortIdentifier> portIdentifierList = new ArrayList<>();
        CommPortIdentifier portIdentifier;

        while(commPortIdentifiers.hasMoreElements()){
            portIdentifier = castToPortIdentifier(
                commPortIdentifiers.nextElement()
            );
            portIdentifierList.add(portIdentifier);
        }

        return portIdentifierList;
    }

    private CommPortIdentifier castToPortIdentifier(Object portIdentifier){
        return (CommPortIdentifier)(portIdentifier);
    }

    private List<CommPortIdentifier> filterForSerialPorts(
            List<CommPortIdentifier> identifierList){

        List<CommPortIdentifier> serialPorts = new ArrayList<>(
            identifierList.size()
        );

        for(CommPortIdentifier identifier: identifierList){
            if(identifier.getPortType() == CommPortIdentifier.PORT_SERIAL){
                serialPorts.add(identifier);
            }
        }

        return serialPorts;
    }

    private List<String> getPortNamesForList(
        List<CommPortIdentifier> portIdentifiers
    ){
        List<String> portNames = new ArrayList<>(portIdentifiers.size());

        for(CommPortIdentifier identifier: portIdentifiers){
            portNames.add(identifier.getName());
        }

        return portNames;
    }
}
