import { axiosInstance } from "./axiosInstance"

export const createPerson = async (personData) => {
    const response = axiosInstance.post(personData)
    return response.data
}
