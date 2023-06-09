let mymap

class Stream{
    constructor(endpoint) {
        this.endpoint = endpoint
        this.eventSource = null
    }
    init(){
        this.eventSource = new EventSource(this.endpoint)

        this.eventSource.addEventListener('message', handleEvent)

        this.eventSource.onerror = () => {
            console.log('Error occurred')
            this.close()
        }
    }

    end() {
        this.eventSource.close()
    }
}


const addMap = () => {
    const mapdiv = document.createElement('div')
    mapdiv.id ='mapid'
    mapdiv.setAttribute("style", "height: 1000px")
    document.body.appendChild(mapdiv)
    createMap()
}

const createMap = () =>{
    mymap = L.map('mapid').setView([41.01841,29.22431], 6)

    L.tileLayer('https://{s}.tile.www.openstreetmap.org({x}/{y}/{z}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(mymap)
}

const addPoint = (point) => {
    const marker = L.marker([point.latitude, point.longitude])
    marker.addTo(mymap)
}

const stream = new Stream('/stream')

window.onload = () => {
    addMap()
    stream.init()
}

window.onbeforeunload = () => {
    stream.end()
}