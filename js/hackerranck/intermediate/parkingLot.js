class ParkingLot {
    constructor(slots) {
        this.slots = slots;
        this.parkingLot = this.getParkingLot();
    }

    getParkingLot() {
        let parkingLot = [];

        for (let i = 1; i <= this.slots; i++) {
            parkingLot.push('empty');
        }

        return parkingLot;
    }

    park(carId) {
        let slot = this.parkingLot.indexOf('empty');

        if (slot > -1) {
            this.parkingLot[slot] = carId;
            return true;
        }

        return false;
    }

    getSlots() {
        return this.parkingLot.map((slot) => (slot === 'empty' ? null : slot));
    }

    remove(carId) {
        let isExistCarId = this.parkingLot.includes(carId);

		if (isExistCarId) {
			this.parkingLot[this.parkingLot.indexOf(carId)] = 'empty';
		}

        return isExistCarId;
    }
}

let parkin = new ParkingLot(5);
console.log(parkin.park('CAR-10'));
console.log(parkin.park('CAR-20'));
console.log(parkin.park('CAR-30'));
console.log(parkin.getSlots());
console.log(parkin.remove('CAR-20'));
console.log(parkin.getSlots());
